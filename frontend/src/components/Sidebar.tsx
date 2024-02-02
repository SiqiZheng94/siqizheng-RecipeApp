import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IconDefinition } from '@fortawesome/fontawesome-svg-core';

interface LinkItem {
    name: string;
    path: string;
    icon: IconDefinition;
}

interface SidebarProps {
    links: LinkItem[];
    close: () => void;
}

const Sidebar: React.FC<SidebarProps> = ({ links, close }) => {
    const location = useLocation();

    return (
        <div
            className="sidebar"
            onClick={close}
            onKeyDown={() => {}}
            role="button"
            tabIndex={0}
        >
            {links.map((link) => (
                <Link
                    to={link.path}
                    className={
                        location.pathname === link.path ? 'sidebar-link active' : 'sidebar-link'
                    }
                    key={link.name}
                >
                    <FontAwesomeIcon icon={link.icon} />
                    {link.name}
                </Link>
            ))}
        </div>
    );
};

export default Sidebar;
